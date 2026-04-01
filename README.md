# testGuardAI

This repository is used to generate pull requests for CodeGuard AI review demos.

The sample files under `src/` intentionally contain insecure and low-quality code
patterns so the review pipeline can produce findings for:
- SQL injection risk
- swallowed exceptions and null handling issues
- debug output and readability hints
