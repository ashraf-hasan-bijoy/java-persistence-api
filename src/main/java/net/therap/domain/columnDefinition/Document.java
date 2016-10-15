package net.therap.domain.columnDefinition;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
@Entity
@Table(name = "table_document")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "document_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "document_generator", sequenceName = "document_sequence", allocationSize = 1)
    private long id;

    @Column(name = "doc_name")
    private String name;

    @Column(unique = true, updatable = false, nullable = false)
    private String documentId;

    @Column(length = 3000)
    private String description;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] data;

    @Column(columnDefinition = "NUMBER (10, 2)")
    private double rating;

    @Temporal(value = TemporalType.DATE)
    private Date eventDate;

    @Temporal(value = TemporalType.TIME)
    private Date eventTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date eventTimestamp;

    @Enumerated(value = EnumType.ORDINAL)
    private Color color;

    @Enumerated(value = EnumType.STRING)
    private Shape shape;

    private String password;

    transient private String confirmPassword;

    @Transient
    private int failedAttempt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Date getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Date eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getFailedAttempt() {
        return failedAttempt;
    }

    public void setFailedAttempt(int failedAttempt) {
        this.failedAttempt = failedAttempt;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", documentId='" + documentId + '\'' +
                ", description='" + description + '\'' +
                ", data=" + new String(data) +
                ", rating=" + rating +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", eventTimestamp=" + eventTimestamp +
                ", color=" + color +
                ", shape=" + shape +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", failedAttempt=" + failedAttempt +
                '}';
    }
}
