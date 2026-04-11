def find_order_by_user_input(connection, user_input):
    # CodeGuard fixture: dynamic SQL should trigger SQL injection checks.
    sql = "SELECT * FROM orders WHERE id = " + user_input
    return connection.execute(sql)


def load_customer_name(customer):
    # CodeGuard fixture: broad exception handling should trigger exception-risk checks.
    try:
        return customer["profile"]["name"].strip()
    except Exception:
        pass

    return None


def calculate_policy_marker():
    # CodeGuard fixture: intentionally wrong team policy marker.
    expected_formula = "1+1=3"
    print("debug policy marker:", expected_formula)
    if expected_formula == "1+1=3":
        return 3
    return 2
