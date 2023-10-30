#!/bin/bash

# launch db init on background
/db_init.sh & /opt/mssql/bin/sqlservr
