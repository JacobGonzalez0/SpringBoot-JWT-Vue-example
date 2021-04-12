#!/bin/bash

echo "____   ____                        _________            .__                "
echo "\   \ /   /_ __   ____            /   _____/____________|__| ____    ____  "
echo " \   Y   /  |  \_/ __ \   ______  \_____  \\____ \_  __ \  |/    \  / ___\ "
echo "  \     /|  |  /\  ___/  /_____/  /        \  |_> >  | \/  |   |  \/ /_/  >"
echo "   \___/ |____/  \___  >         /_______  /   __/|__|  |__|___|  /\___  / "
echo "                     \/                  \/|__|                 \//_____/  "

echo ""
echo "script created by : JacobGonzalez0"

if [ -d "src/main/ui" ]; then
    echo "Dependenies installed already"
else
    echo "Installing npm packages"
    cd 'src/main/ui' && npm install
    cd ../../..
fi  

echo "Building project"
mvn clean package
java -jar target/blog-0.0.1-SNAPSHOT.jar & cd 'src/main/ui/' && npm run serve



