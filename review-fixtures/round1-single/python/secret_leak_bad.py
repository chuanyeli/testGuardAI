DB_PASSWORD = "prod-password-123"
INTERNAL_TOKEN = "bearer hardcoded-access-token"
API_KEY = "demo-api_key-unsafe"


def build_headers() -> dict:
    return {
        "Authorization": INTERNAL_TOKEN,
        "X-Api-Key": API_KEY,
    }

