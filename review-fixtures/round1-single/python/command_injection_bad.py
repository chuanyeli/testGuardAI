import os
import subprocess


def export_logs(keyword: str) -> None:
    os.system("grep -R '" + keyword + "' ./logs")


def package_backup(target: str) -> None:
    subprocess.run("tar -czf backup.tar.gz " + target, shell=True, check=False)

