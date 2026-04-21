SELECT 'CREATE DATABASE collab'
    WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'collab')\gexec