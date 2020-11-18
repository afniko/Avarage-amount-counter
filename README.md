## Task
You are working at COMPANY_NAME and your team is asked to build a microservice that will calculate
real-time statistics of item sales on COMPANY_NAME marketplace platform. This microservice will feed
data to a dashboard installed in a business team’s room.
The microservice shall have a REST interface with two endpoints. The first endpoint will be
called by the checkout service whenever a new payment is received and the second
endpoint will provide statistics about the total order amount and average amount per order
for the last 60 seconds. (Orders between t and t - 60 sec, given t = request time)

### Specifications for the requested endpoints are as follows:
#### Transactions
URL: /sales
PORT: 8780
Method: POST
Content-Type: application/x-www-form-urlencoded
Parameters:
Name Required Type
sales_amount Yes Number String (e.g. “10.00”)
Return HTTP Code: 202 Accepted
Return Body: blank
#### Statistics
URL: /statistics
PORT: 8780
Method: GET
Parameters: none
Return HTTP Code: 200 OK
Return Body:
{
“total_sales_amount”: “1000000.00”,
“average_amount_per_order”: “45.04”
}

## Structure
Project contain two services:
- average-amount-counter
- sales-generator

### average-amount-counter
Main service receive info and count statistic

### sales-generator
Emulate sales per 70ms with random amount

#### Start
```
./gradlew clean build && sudo docker-compose up --build
```
