alter table task_progress add column assigned_by bigint references users(user_id);