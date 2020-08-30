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

* Response body