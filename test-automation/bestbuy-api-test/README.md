# bestbuy-api-test
Demo testcases on BestBuy APIs using: Postman, Newman

## Prerequisites

Follow the guide to setup Postman:
 https://learning.getpostman.com/docs/postman/launching_postman/installation_and_updates

Follow the guide to setup Newman:
 https://learning.postman.com/docs/running-collections/using-newman-cli/command-line-integration-with-newman/

Install and start local connection to BestBuy APIs
```
git clone https://github.com/BestBuy/api-playground.git
cd api-playground
npm install
npm start
```


## How to run using Postman

```
Download all bestbuy-api-test folder content to your pc
Import BestBuyAPI.postman_collection.json file to postman
Import BestBuyAPI.postman_environment.json file to postman
Run collection using BestBuyData.csv
```


## How to run using Newman

```
git clone https://github.com/PierreKhouzam/pierre-khouzam.git
cd test-automation/bestbuy-api-test
newman run BestBuyAPI.postman_collection.json -e BestBuyAPI.postman_environment.json -d BestBuyData.csv
```

## Test cases

> endpoints:
> * /products
> * /stores
> * /services
> * /categories
> * /version
> * /healthcheck

* Return all items - no filters

    * Status code is 200
    * Item Scheme is valid
    * Item data is available
    * Default page limit is correct
    * Default skip is correct

* Return all Item - limit output and skip

    * Status code is 200
    * Returned values of skip and limit are correct
    * Item data should be empty when limit is set to zero

* Create a new Item

    * Status code is 201
    * Item data schema is valid
    * Responce contains Item id

* Select Item by id

    * Status code is 200
    * Item data schema is valid

* Update an Item based on ID

    * Status code is 200
    * Item data is updated

* Delete a single Item based on the ID supplied

    * Status code is 200
    * Deleted Item cannot be found

### Specific tests for "/version" and "/healthcheck" endpoints
* Returns the current version of the API Playground being run

    * Status code is 200

* Returns healthcheck information about the system
    * Status code is 200
