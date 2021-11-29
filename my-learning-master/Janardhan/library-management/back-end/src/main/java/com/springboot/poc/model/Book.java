package com.springboot.poc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn_number")
    private String isbnNumber;

    @Column(name = "total_stock")
    private Long totalStock;

    @Column(name = "available_stock")
    private Long availableStock;

    @Column(name = "price")
    private Double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    @Enumerated(EnumType.STRING)
    private Publisher publisher;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id") , inverseJoinColumns = @JoinColumn(name = "author_id") )
    private Set<Author> authors = new HashSet<Author>();

    public Book() {

    }

    /**
     * @param title
     * @param isbnNumber
     * @param totalStock
     * @param availableStock
     * @param price
     * @param author
     * @param publisher
     */
    public Book(String title, String isbnNumber, Long totalStock,
            Long availableStock, Double price, final Publisher publisher) {
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.totalStock = totalStock;
        this.availableStock = availableStock;
        this.price = price;
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
    public Set<Author> getAuthors() {
        return authors;
    }

    /**
     * @param authors
     *            the authors to set
     */
    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    /**
     * @return the publisher
     */
    public Publisher getPublisher() {
        return publisher;
    }

    /**
     * @param publisher
     *            the publisher to set
     */
    public void setPublisher(Publisher publisher) {
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
        final Book book = (Book) obj;
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
