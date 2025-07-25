#!/bin/bash

echo "Cleaning up .DS_Store files and target directories..."

# Delete all .DS_Store files
find . -name ".DS_Store" -type f -print -delete

# Delete all target directories
find . -type d -name "target" -print -exec rm -rf {} +

echo "Cleanup complete."