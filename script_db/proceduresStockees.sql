DROP PROCEDURE IF EXISTS update_score_msg
CREATE PROCEDURE update_score_msg(INTEGER message_id, BOOLEAN up_vote)
LANGUAGE SQL
AS $$
BEGIN 
	  DECLARE var INTEGER;
   	 IF up_vote IS TRUE THEN
              SET var = 1;
        ELSE
               SET var = -1;
        END IF;
		
    -- updating score in message
    UPDATE message
    SET score = score + var;
	WHERE message.message_id = message_id;
END update_score_msg;
$$;