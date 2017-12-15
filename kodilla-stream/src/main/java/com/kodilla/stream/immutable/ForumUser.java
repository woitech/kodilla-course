package com.kodilla.stream.immutable;

public final class ForumUser {
    private final String username;
    private final String realName;

    public ForumUser(final String username, final String realName) {
        if (username == null || username.isEmpty()
                || realName == null || realName.isEmpty())
            throw new IllegalArgumentException("valueless argument(s)");
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        if (!username.equals(forumUser.username)) return false;
        return realName.equals(forumUser.realName);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + realName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ForumUser{" + "username='" + username + '\'' +
                ", realName='" + realName + '\'' + '}';
    }
}
