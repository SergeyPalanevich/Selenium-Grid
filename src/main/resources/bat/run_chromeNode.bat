set SERVER_VERSION=3.8.1
set NODE_CONFIG=chromeNode.json
set CHROME_DRIVER=chromedriver.exe
set REGISTER_IP=localhost:4444

java -Dwebdriver.chrome.driver=%CHROME_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role node -hub http://%REGISTER_IP%/grid/register -nodeConfig %NODE_CONFIG%

pause