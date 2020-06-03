# Lab Inventory

## Description
This lab will help you more understand about Inventory.

## Exercise

1. Create a static Inventory with following description:
  - Web ( ip 10.0.0.71, 10.0.1.71, 10.0.2.70, 10.0.2.71)
  - Api ( ip 10.0.0.72, 10.0.1.72, 10.0.2.72, 10.0.2.73)
  - Environment nightly: 10.0.0.71, 10.0.0.72 => using ssh_key: dev.pem
  - Environment staging: 10.0.1.71, 10.0.1.72 => using ssh_key: staging.pem
  - Environment prod: 10.0.2.71, 10.0.2.72 => using ssh_key: prod.pem
  - user_ssh: ubuntu

2. Create a Inventory to run localhost

3. Create a dynamic Inventory with following description:
  - Resource AWS EC2 instances
  - Region: ap-southeast-1
  - Status: running
  - Using: private IP address
  - Tags:
      - Env: prod
      - Name: web / api
