# How to run the code
* ## With docker
1. Set up docker.
2. Start local DB:
    ```shell
   cd db && docker compose up -d db
    ```
3. Start the Main class.

* ## With your exists DB
1. Update `src/main/resources/hibernate.properties` with your DB connection info
2. Start the Main class.
