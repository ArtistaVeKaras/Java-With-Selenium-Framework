# Git Cheatsheet

## Basic Commands
- `git init` - Initialize a new Git repository
- `git clone [url]` - Clone a repository from a remote URL
- `git status` - Show the working tree status
- `git add [file]` - Add file(s) to staging area
- `git commit -m "[message]"` - Commit changes with a message
- `git push` - Push local commits to remote repository
- `git pull` - Fetch from and integrate with another repository
- `git fetch` - Download objects and refs from another repository

## Branching
- `git branch` - List all local branches
- `git branch [branch-name]` - Create a new branch
- `git checkout [branch-name]` - Switch to a branch
- `git checkout -b [branch-name]` - Create and switch to a new branch
- `git merge [branch]` - Merge a branch into the active branch
- `git branch -d [branch-name]` - Delete a branch

## Undoing Changes
- `git reset [file]` - Unstage a file while keeping changes
- `git reset --hard [commit]` - Reset to a specific commit (caution: discards changes)
- `git checkout -- [file]` - Discard changes in working directory
- `git revert [commit]` - Revert a commit by creating a new commit
- `git clean -fd` - Remove untracked files and directories

## Stashing
- `git stash` - Stash changes in a dirty working directory
- `git stash list` - List all stashed changes
- `git stash apply` - Apply the most recent stash
- `git stash pop` - Apply and remove the most recent stash
- `git stash drop` - Remove the most recent stash

## Remote Repositories
- `git remote -v` - List all remote repositories
- `git remote add [name] [url]` - Add a new remote repository
- `git remote remove [name]` - Remove a remote repository
- `git push [remote] [branch]` - Push to a specific remote branch
- `git pull [remote] [branch]` - Pull from a specific remote branch

## Log and History
- `git log` - Show commit logs
- `git log --oneline` - Show compact commit logs
- `git log --graph --oneline --decorate` - Show commit history as a graph
- `git show [commit]` - Show changes in a specific commit
- `git diff` - Show unstaged changes
- `git diff --staged` - Show staged changes

## Tagging
- `git tag` - List all tags
- `git tag [tag-name]` - Create a lightweight tag
- `git tag -a [tag-name] -m "[message]"` - Create an annotated tag
- `git push --tags` - Push tags to remote

## Configuration
- `git config --global user.name "[name]"` - Set your username
- `git config --global user.email "[email]"` - Set your email
- `git config --list` - List all configurations
- `git config --global alias.[alias-name] '[command]'` - Create a git alias

## Advanced
- `git rebase [branch]` - Reapply commits on top of another branch
- `git cherry-pick [commit]` - Apply a specific commit to current branch
- `git bisect` - Use binary search to find the commit that introduced a bug
- `git reflog` - Show a log of all reference updates
- `git fsck` - Verify the integrity of the git database

## Common Workflows
### Create and push a new branch
```bash
git checkout -b feature-branch
# Make changes
git add .
git commit -m "Add new feature"
git push -u origin feature-branch
```

### Update from remote
```bash
git fetch origin
git merge origin/main
# or
git pull origin main
```

### Fix a typo in last commit
```bash
# Make your fix
git add .
git commit --amend --no-edit
# If already pushed
git push --force-with-lease
```

## Troubleshooting
- `git gc` - Cleanup unnecessary files and optimize local repository
- `git fsck --full` - Check database integrity
- `git reflog` - Recover lost commits or changes
- `git update-ref -d HEAD` - Fix broken HEAD reference

## Best Practices
- Write clear, concise commit messages
- Make small, focused commits
- Pull before you push
- Don't rewrite public history
- Use branches for new features and bug fixes
- Keep your repository clean and organized
