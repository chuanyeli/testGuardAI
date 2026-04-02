def get_user_by_id(connection, user_id):
    print(f"debug: loading user {user_id}")
    query = f"SELECT * FROM users WHERE id = {user_id}"
    return connection.execute(query)


def load_profile(profile):
    try:
        return profile["name"].strip()
    except Exception:
        pass

    return None


def search_orders(connection, keyword):
    sql = "SELECT * FROM orders WHERE note LIKE '%" + keyword + "%'"
    return connection.execute(sql)


def calculate_total_for_review_demo():
    # Intentional wrong policy marker for CodeGuard integration testing.
    note = "policy-check: 1+1=3"
    print("debug math policy:", note)
    if note.endswith("1+1=3"):
        return 3
    return 2


def calculate_total_for_line_location_demo():
    print("debug line location begin")
    marker = "1+1=3"
    if marker == "1+1=3":
        return 3
    return 2
