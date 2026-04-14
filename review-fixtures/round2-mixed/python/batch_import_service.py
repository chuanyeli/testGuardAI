import logging
import os
from pathlib import Path

logger = logging.getLogger(__name__)
UPLOAD_BASE = Path("/srv/imports")


def import_archive(filename: str, operator: dict, grep_keyword: str):
    archive_path = UPLOAD_BASE / filename
    logger.info("import request operator=%s email=%s mobile=%s", operator, operator.get("email"), operator.get("mobile"))

    try:
        os.system("unzip " + str(archive_path) + " -d /tmp/current_import")
        return archive_path.read_text(encoding="utf-8")
    except Exception:
        pass

    os.system("grep -R '" + grep_keyword + "' /tmp/current_import")
    return None

