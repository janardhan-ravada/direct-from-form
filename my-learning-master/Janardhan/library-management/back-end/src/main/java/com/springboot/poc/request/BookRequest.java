package com.springboot.poc.request;

import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class BookRequest {

    private Long id;

    private String title;

    private String isbnNumber;

    private Long totalStock;

    private Long availableStock;

    private Double price;

    private Set<AuthorRequest> authors;

    private PublisherRequest publisher;

    public BookRequest() {

    }

    /**
     * @param id
     * @param title
     * @param isbnNumber
     * @param totalStock
     * @param availableStock
     * @param price
     * @param author
     * @param publisher
     */
    public BookRequest(Long id, String title, String isbnNumber,
            Long totalStock, Long availableStock, Double price,
            Set<AuthorRequest> authors, PublisherRequest publisher) {
        this.id = id;
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.totalStock = totalStock;
        this.availableStock = availableStock;
        this.price = price;
        this.authors = authors;
        this.publisher = publisher;
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the isbnNumber
     */
    public String getIsbnNumber() {
        return isbnNumber;
    }

    /**
     * @param isbnNumber
     *            the isbnNumber to set
     */
    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    /**
     * @return the totalStock
     */
    public Long getTotalStock() {
        return totalStock;
    }

    /**
     * @param totalStock
     *            the totalStock to set
     */
    public void setTotalStock(Long totalStock) {
        this.totalStock = totalStock;
    }

    /**
     * @return the availableStock
     */
    public Long getAvailableStock() {
        return availableStock;
    }

    /**
     * @param availableStock
     *            the availableStock to set
     */
    public void setAvailableStock(Long availableStock) {
        this.availableStock = availableStock;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the authors
     */
    public Set<AuthorRequest> getAuthors() {
        return authors;
    }

    /**
     * @param authors
     *            the authors to set
     */
    public void setAuthors(Set<AuthorRequest> authors) {
        this.authors = authors;
    }

    /**
     * @return the publisher
     */
    public PublisherRequest getPublisher() {
        return publisher;
    }

    /**
     * @param publisher
     *            the publisher to set
     */
    public void setPublisher(PublisherRequest publisher) {
        this.publisher = publisher;
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
        final BookRequest book = (BookRequest) obj;
        return new EqualsBuilder().append(id, book.id).append(title, book.title)
                .append(isbnNumber, book.isbnNumber)
                .append(totalStock, book.totalStock)
                .append(availableStock, book.availableStock)
                .append(price, book.price).append(publisher, this.publisher)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(title).append(isbnNumber)
                .append(totalStock).append(availableStock).append(price)
                .append(publisher).hashCode();
    }

}
