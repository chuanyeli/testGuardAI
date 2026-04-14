from pathlib import Path


BASE_DIR = Path("/srv/uploads").resolve()


def read_file(filename: str) -> str:
    if ".." in filename or filename.startswith("/"):
        raise ValueError("invalid filename")

    target = (BASE_DIR / filename).resolve()
    if BASE_DIR not in target.parents and target != BASE_DIR:
        raise ValueError("path out of base dir")

    return target.read_text(encoding="utf-8")

