# siimple-interest

#### **URL:** http://localhost:8080/
#### **Health:** http://localhost:8080/actuator/health

#### **credits:** http://localhost:8080/credits
#### **GET:**
```json
[
    {
        "id": Integer,
        "amount": Double,
        "terms": Integer,
        "rate": Double,
        "payments": [
            {
                "id": Integer,
                "amount": Double,
                "payment_number": Integer,
                "payment_date": Date
            }
        ]
    }
]
```
#### **POST:**
```json
{
    "amount": Double,
    "terms": Integer,
    "rate": Double
}
```
#### **Response:**
```json
{
    "id": Integer,
    "amount": Double,
    "terms": Integer,
    "rate": Double,
    "payments": [
        {
            "id": Integer,
            "amount": Double,
            "payment_number": Integer,
            "payment_date": Date
        }
    ]
}
```
