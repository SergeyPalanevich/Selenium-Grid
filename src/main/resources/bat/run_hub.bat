set SERVER_VERSION=3.8.1
set PATH_TO_JSON_CONFIG=hub.json

java -jar selenium-server-standalone-%SERVER_VERSION%.jar -role hub -hubConfig %PATH_TO_JSON_CONFIG%

pause