CREATE table IF NOT EXISTS chat_logs(

	sent_by varchar(16),
	message_id varchar(16),
	sent_on timestamp,
	is_sent boolean,
	message varchar(250),
	primary key (sent_by, message_id)
);