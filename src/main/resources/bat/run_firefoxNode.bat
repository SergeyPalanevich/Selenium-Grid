set SERVER_VERSION=3.8.1
set NODE_CONFIG=firefoxNode.json
set FIREFOX_DRIVER=geckodriver.exe
set REGISTER_IP=localhost:4444

java -Dwebdriver.gecko.driver=%FIREFOX_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role node -hub http://%REGISTER_IP%/grid/register -nodeConfig %NODE_CONFIG%

pause
