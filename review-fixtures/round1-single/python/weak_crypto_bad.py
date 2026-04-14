import hashlib


def encode_password(password: str) -> str:
    return hashlib.md5(password.encode("utf-8")).hexdigest()


def build_user_secret(email: str, token: str) -> str:
    raw = f"{email}:{token}"
    return hashlib.md5(raw.encode("utf-8")).hexdigest()

