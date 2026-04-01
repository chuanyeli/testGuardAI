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
