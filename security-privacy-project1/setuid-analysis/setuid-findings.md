
---

### 📄 `setuid-analysis/setuid-findings.md`

```markdown
# Linux SetUID Shell Analysis 🧪

This analysis explores the security implications of using SetUID with Linux shells such as `bash` and `zsh`.

## 🧪 Observations

### ✅ `zsh` with SetUID:
- When executed with the SetUID bit, `zsh` inherits **root privileges** if owned by root and executed by another user (like `seed`).
- This can allow privilege escalation.

### ❌ `bash` with SetUID:
- `bash` intentionally ignores the SetUID bit for security reasons.
- Even if permissions are set to 4755, it **won’t elevate privileges**.

## ⚠️ Security Concerns

### PATH Hijacking Example:
```bash
PATH=/home/seed/tmp1:$PATH
touch ls
nano ls # malicious command
chmod +x ls
