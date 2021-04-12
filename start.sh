#!/bin/bash

echo "____   ____                        _________            .__                "
echo "\   \ /   /_ __   ____            /   _____/____________|__| ____    ____  "
echo " \   Y   /  |  \_/ __ \   ______  \_____  \\____ \_  __ \  |/    \  / ___\ "
echo "  \     /|  |  /\  ___/  /_____/  /        \  |_> >  | \/  |   |  \/ /_/  >"
echo "   \___/ |____/  \___  >         /_______  /   __/|__|  |__|___|  /\___  / "
echo "                     \/                  \/|__|                 \//_____/  "

echo ""
echo "script created by : JacobGonzalez0"

if npm list -g | grep "@vue/cli"; then
    echo "Vue installed already"
else
    echo "Installing Vue-CLI"
    npm install -g @vue/cli @vue/cli-plugin-babel @vue/cli-plugin-eslint @vue/cli-plugin-router @vue/cli-plugin-vuex 
fi

echo "Building project"
cd 'src/main/ui' && npm linstall
cd ../../..
./mvnw spring-boot:run & cd 'src/main/ui/' && npm run serve



