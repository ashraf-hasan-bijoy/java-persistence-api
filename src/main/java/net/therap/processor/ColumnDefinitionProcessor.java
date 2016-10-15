package net.therap.processor;

import net.therap.domain.columnDefinition.Color;
import net.therap.domain.columnDefinition.Document;
import net.therap.domain.columnDefinition.Shape;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author ashrafhasan
 * @since 10/11/16
 */
public class ColumnDefinitionProcessor implements DbCommandProcessor {
    Logger logger = LoggerFactory.getLogger(ColumnDefinitionProcessor.class);

    @Override
    public void process(EntityManager entityManager) {

        InputStream fileStream = this.getClass().getClassLoader().getResourceAsStream("sampleFile.txt");

        Document document = new Document();
        try {
            Date date = new Date();
            document.setName("doc");
            document.setDocumentId("123");
            document.setDescription("description");
            document.setData(IOUtils.toByteArray(fileStream));
            document.setEventDate(date);
            document.setEventTime(date);
            document.setEventTimestamp(date);
            document.setPassword("password");
            document.setConfirmPassword("password");
            document.setFailedAttempt(1);
            document.setColor(Color.BLACK);
            document.setShape(Shape.RECTANGULAR);

            entityManager.persist(document);

            entityManager.flush();
            entityManager.detach(document);

            document = entityManager.find(Document.class, document.getId());

            logger.debug("document : {}", document);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        /*
            DESC table_document;

            SELECT id,
              color,
              description,
              document_id,
              to_char(event_date, 'MM-DD-YYYY HH24:MI'),
              to_char(EVENT_TIME, 'MM-DD-YYYY HH24:MI'),
              EVENT_TIMESTAMP,
              doc_name,
              password,
              rating,
              shape
            FROM table_document;
        */

    }
}
