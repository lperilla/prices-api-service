# TEST Prices Api Service

This is technical test Developer Backend.

## URLS

- *Endpoint:* http://localhost:8080/api/brands/{brandId}/products/{productId}/prices

    It is required the follow params:
	
	| Params          | Param Type | Description        | Type Data     | Example            |
	|-----------------|----------- | ------------------ |---------------|--------------------|
	| applicationDate | query      | Application date   | date-time     |2020-06-14T10:00:00 |
	| productId       | path       | Product identifier | integer       |35455               |
	| brandId         | path       | brand identifier   | integer       |1                   |
 
- *API Swagger Definition:* https://app.swaggerhub.com/apis/LUISPERILLA/prices-api-service/1.0.0