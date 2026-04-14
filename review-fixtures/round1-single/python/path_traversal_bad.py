from pathlib import Path


BASE_DIR = Path("/srv/uploads")


def read_file(filename: str) -> str:
    target = BASE_DIR / filename
    return target.read_text(encoding="utf-8")


def unzip_entry(zip_entry_name: str) -> Path:
    target = BASE_DIR / zip_entry_name
    target.parent.mkdir(parents=True, exist_ok=True)
    return target

