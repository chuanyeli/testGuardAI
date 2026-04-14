def load_profile(repository, user_id: str):
    try:
        return repository.find(user_id)
    except Exception:
        return None


def remove_profile(repository, user_id: str) -> bool:
    try:
        repository.delete(user_id)
        return True
    except Exception:
        pass
    return False

