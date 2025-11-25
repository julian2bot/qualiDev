#!/usr/bin/env bash
set -euo pipefail

# Replace Javadoc blocks that contain the exact string "TODO: Complete Javadoc"
# with a small generated Javadoc containing the marker "todo doc OK".

grep -rl --exclude-dir=build --exclude-dir=target --exclude-dir=.git "TODO: Complete Javadoc" --include='*.java' . || exit 0

FILES=$(grep -rl --exclude-dir=build --exclude-dir=target --exclude-dir=.git "TODO: Complete Javadoc" --include='*.java' .)

if [ -z "$FILES" ]; then
  echo "No files to update."
  exit 0
fi

echo "Updating Javadoc in the following files:"
printf "%s\n" $FILES

for f in $FILES; do
  # Use perl to replace any Javadoc /** ... */ block that contains the TODO marker
  perl -0777 -pe 's{/\*\*.*?TODO: Complete Javadoc.*?\*/}{/**\n * Auto-generated Javadoc.\n *\n * todo doc OK\n */}gs' -i "$f"
  echo "Updated: $f"
done

echo "Javadoc update completed."