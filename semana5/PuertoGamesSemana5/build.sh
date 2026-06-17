#!/bin/bash
set -euo pipefail

ROOT="$(cd "$(dirname "$0")" && pwd)"
OUT="$ROOT/out"
CLASSES="$OUT/classes"
JAR_DIR="$OUT/jar"
JAR_FILE="$OUT/PuertoGamesSemana5.jar"

rm -rf "$OUT"
mkdir -p "$CLASSES" "$JAR_DIR"

find "$ROOT/src/main/java" -name "*.java" > "$OUT/sources.txt"
javac -encoding UTF-8 -d "$CLASSES" @"$OUT/sources.txt"
cp -R "$ROOT/src/main/resources/." "$CLASSES/"

cat > "$OUT/manifest.txt" <<'EOF'
Main-Class: com.puertogames.ui.Main
EOF

jar cfm "$JAR_FILE" "$OUT/manifest.txt" -C "$CLASSES" .

echo "Compilacion lista: $JAR_FILE"
