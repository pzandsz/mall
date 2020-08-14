#ARGS="-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=6208 -Dspring.config.location=/home/admin/software/uic/application.properties"

ARGS="-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=6208 -Dnacos.group.id=daily -Dnacos.server-addr=10.0.10.86:8848 -Dspring.profiles.active=daily"