#!/usr/bin/env bash
set -euo pipefail
mvn -B clean test
echo "Project validation completed."
