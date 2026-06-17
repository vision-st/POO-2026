#!/bin/bash
set -euo pipefail

ROOT="$(cd "$(dirname "$0")" && pwd)"
OUT="$ROOT/out/classes"

if [ ! -d "$OUT" ]; then
  "$ROOT/build.sh"
fi

java -cp "$OUT" com.puertogames.ui.Main
