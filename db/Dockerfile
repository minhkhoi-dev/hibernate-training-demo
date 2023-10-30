FROM mcr.microsoft.com/mssql/server:2019-latest

USER root
RUN mkdir -p /docker-entrypoint-initdb.d
RUN mkdir -p /var/log/docker/
RUN chown mssql /var/log/docker/

USER mssql
RUN echo ""> /var/log/docker/sqlserver_db_init.log
COPY --chmod=775 entrypoint.sh /entrypoint.sh
COPY --chmod=775 db_init.sh /db_init.sh
ENTRYPOINT ["./entrypoint.sh"]