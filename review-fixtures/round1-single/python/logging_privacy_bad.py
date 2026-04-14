import logging

logger = logging.getLogger(__name__)


def login(user_info: dict, trace_id: str) -> None:
    email = user_info.get("email")
    mobile = user_info.get("mobile")
    token = user_info.get("access_token")
    print("debug login", trace_id, email, mobile, token)
    logger.info(
        "login request traceId=%s requestId=%s userInfo=%s email=%s mobile=%s token=%s",
        trace_id,
        user_info.get("requestId"),
        user_info,
        email,
        mobile,
        token,
    )

