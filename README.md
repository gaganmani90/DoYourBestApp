## Build
`mvn package`

## Endpoints

### Create
This is to create a record.

http://localhost:8080/create

Request body: 
```json
{
    "id": 11,
    "note": "gagan mani",
    "isBestDay": false,
   "date": "20/10/1988"
}
```

### Fetch

http://localhost:8080/fetch

* Request body

```json
{
    "id": 1
}
```

* Response
```json
{
    "errorMessage": null,
    "retroCalendarInventory": {
        "userDaysMap": {
            "11": {
                "retroDays": [
                    {
                        "userId": 11,
                        "note": "gagan mani",
                        "date": "1988-10-20T07:00:00.000+0000",
                        "myBestDay": false
                    },
                    {
                        "userId": 11,
                        "note": "gagan mani",
                        "date": "1989-10-20T07:00:00.000+0000",
                        "myBestDay": false
                    }
                ]
            },
            "12": {
                "retroDays": [
                    {
                        "userId": 12,
                        "note": "Shivani",
                        "date": "1989-10-20T07:00:00.000+0000",
                        "myBestDay": false
                    }
                ]
            }
        }
    }
}
```