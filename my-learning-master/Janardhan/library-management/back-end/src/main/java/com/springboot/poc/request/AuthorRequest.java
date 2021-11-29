package com.springboot.poc.request;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class AuthorRequest {

    private Long id;

    private String name;

    private String emailAddress;

    public AuthorRequest() {

    }

    /**
     * @param id
     * @param name
     */
    public AuthorRequest(final Long id, final String name,
            final String emailAddres) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddres;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress
     *            the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuthorRequest author = (AuthorRequest) obj;
        return new EqualsBuilder().append(id, author.id)
                .append(name, author.name)
                .append(emailAddress, author.emailAddress).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name)
                .append(emailAddress).hashCode();
    }
}
