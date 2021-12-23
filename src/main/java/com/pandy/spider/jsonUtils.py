import json
payload = json.dumps({
    "real":{
        "open":True,
        "rob":{
            "open":True
        },
        "dispatch":{
            "open":True
        },
        "downgrade":{
            "open":True,
            "car_type_list":"1,2,4"
        },
        "area":{
            "del_fence_favorite":True,
            "del_fence_forbid":True,
            "open_favorite_area":False,
            "open_forbid_area":False
        }
    },
    "receiving_strategy":{
        "peak_high_unit_price":False,
        "peak_more_orders":True,
        "flat_quantity_price_balance":False,
        "flat_more_orders":True
    },
    "incidentally":{
        "open":False,
        "range":{
            "percentage":0
        },
        "poi":{
            "name":"",
            "poi_id":"",
            "longitude":0,
            "latitude":0,
            "address":""
        }
    },
    "speedup_coupon":{
        "open":True,
        "speedup_type":3
    }}
)
