package product


import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'post'
        url '/products'
        body("""
    {
      "name":"1234567890",
      "sku":99999,
      "desc": "test"
    }
    """)
        headers {
            header('Content-Type', 'application/json')
        }
    }
    response {
        status 200
        body("""
  {
    "fraudCheckStatus": "FRAUD",
    "rejectionReason": "Amount too high"
  }
  """)
        headers {
            header('Content-Type': 'application/vnd.fraud.v1+json')
        }
    }
}

