drop table if exists user;
drop table if exists wishtree;
drop table if exists balanceq;
drop table if exists bamboo;
drop table if exists todaysluck;
drop table if exists todayslunch;

CREATE TABLE user (
    user_id VARCHAR(20) NOT NULL,
    user_password VARCHAR(32) NULL,
    user_name VARCHAR(32) NOT NULL,
    user_phone VARCHAR(13) NOT NULL,
    user_birthdate DATE NULL,
    user_gender VARCHAR(15) NULL,
    ranking INT NULL,
    total_score INT NULL,
    game_date DATE NULL,
    daily_vist INT NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE balanceq (
    `index` INT NOT NULL AUTO_INCREMENT,
    question_number INT NOT NULL,
    answer_left BOOLEAN NOT NULL,
    score_s INT NOT NULL,
    score_c INT NOT NULL,
    score_h INT NOT NULL,
    score_d INT NOT NULL,
    problem VARCHAR(100) NOT NULL,
    answer VARCHAR(250) NOT NULL,
    PRIMARY KEY (`index`)
);

CREATE TABLE wishtree (
    user_id VARCHAR(20) NOT NULL,
    user_wish VARCHAR(100) NOT NULL,
    wish_date DATETIME NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE todaysluck (
    `index` INT NOT NULL AUTO_INCREMENT,
    card_type ENUM('SPADE', 'CLOVER', 'HEART', 'DIAMOND') NOT NULL,
    card_number INT NOT NULL,
    card_result VARCHAR(250) NOT NULL,
    PRIMARY KEY (`index`)
);

CREATE TABLE todayslunch (
    `index` INT NOT NULL AUTO_INCREMENT,
    lunch_max ENUM('SPADE', 'CLOVER', 'HEART', 'DIAMOND') NOT NULL,
    lunch_min ENUM('SPADE', 'CLOVER', 'HEART', 'DIAMOND') NOT NULL,
    lunch_result VARCHAR(300) NOT NULL,
    PRIMARY KEY (`index`)
);

CREATE TABLE bamboo (
    user_id VARCHAR(20) NOT NULL,
    comment VARCHAR(250) NOT NULL,
    comment_date DATETIME NOT NULL
);



INSERT INTO user (user_id, user_password, user_name, user_phone, user_birthdate, user_gender, ranking, total_score, game_date, daily_vist)
VALUES 
('skyblue95', 'abc12345', '김하늘', '010-1234-5678', '1995-06-15', 'FEMALE', NULL, NULL, NULL, 3),
('joonho98', 'qwerty456', '이준호', '010-2345-6789', '1998-09-20', 'MALE', NULL, NULL, NULL, 1),
('soyoung93', 'password123', '박소영', '010-3456-7890', '1993-03-10', 'FEMALE', NULL, NULL, NULL, 2),
('minsoo97', 'secure0987', '최민수', '010-4567-8901', '1997-11-05', 'MALE', NULL, NULL, NULL, 4),
('jimin90', 'hello5678', '정지민', '010-5678-9012', '1990-01-22', 'FEMALE', NULL, NULL, NULL, 5),
('yuna03', 'pass12345', '김유나', '010-1111-2222', '2003-04-12', 'FEMALE', NULL, NULL, NULL, 2),
('hyeonjun05', 'secure54321', '이현준', '010-2222-3333', '2005-09-08', 'MALE', NULL, NULL, NULL, 3),
('minji01', 'abc98765', '박민지', '010-3333-4444', '2001-12-25', 'FEMALE', NULL, NULL, NULL, 1),
('seojun04', 'hello67890', '최서준', '010-4444-5555', '2004-06-15', 'MALE', NULL, NULL, NULL, 5),
('jiwoo02', 'qwerty987', '정지우', '010-5555-6666', '2002-11-30', 'FEMALE', NULL, NULL, NULL, 4);


INSERT INTO wishtree (user_id, user_wish, wish_date) 
VALUES 
('yuna03', '올해는 공부도 잘 되고 건강했으면 좋겠어요🙏🎓', '2025-01-01 08:30:00'),
('hyeonjun05', '새해에는 원하는 꿈을 꼭 이루고 싶어요.🔥', '2025-01-02 09:45:00'),
('minji01', '2025년은 건강하기만 가득하길! 💪💪💪', '2025-01-03 10:15:00'),
('seojun04', '행복과 웃음이 가득한 한 해 보내기😊', '2025-01-04 11:20:00'),
('jiwoo02', '모든 일이 잘 풀리고 건강한 새해 되길🙏', '2025-01-05 12:35:00'),
('skyblue95', '2025년에는 더 많은 추억을 만들기💖💖', '2025-01-06 14:00:00'),
('soyoung93', '결혼하게 해주세요..😊', '2025-01-07 15:15:00');

INSERT INTO bamboo (user_id, comment, comment_date)
VALUES 
('soyoung93', '정말 좋은 소원이네요 😊💬', '2025-01-06 10:05:00'),
('minsoo97', '항상 응원합니다. 🙌', '2025-01-07 11:20:00'),
('jimin90', '👏 잘 보고 갑니다.✨', '2025-01-08 15:45:00'),
('skyblue95', '새해 복 많이 받으세요🙏', '2025-01-09 13:10:00'),
('joonho98', '마음이 따뜻해지는 소원입니다. 🧡😊', '2025-01-10 17:30:00'),
('hyeonjun05', '진짜 공감되는 소원이에요 👍🔥', '2025-01-16 14:00:00'),
('minji01', '🌟 응원합니다💖', '2025-01-17 15:15:00'),
('seojun04', '📝 잘 보고 갑니다. 🙏', '2025-01-18 16:30:00'),
('jiwoo02', '행복한 하루 되세요🌼💛', '2025-01-19 17:45:00'),
('yuna03', '힘들 땐 쉬어가도 괜찮아요🌈💪', '2025-01-20 19:00:00');

INSERT INTO todaysluck VALUES
(1, 'SPADE', 2, '학업운 최악... 오늘은 바람 쐬러 가시는거 추천'),
(2, 'SPADE', 3, '공부하시는 중 차질이 생길 수 있습니다.'),
(3, 'SPADE', 4, '공부하시는 중 차질이 생길 수 있습니다.'),
(4, 'SPADE', 5, '공부하시는 중 차질이 생길 수 있습니다.'),
(5, 'SPADE', 6, '공부하시는 중 차질이 생길 수 있습니다.'),
(6, 'SPADE', 7, '평소 페이스 유지하시면서 공부하세요'),
(7, 'SPADE', 8, '평소 페이스 유지하시면서 공부하세요'),
(8, 'SPADE', 9, '평소 페이스 유지하시면서 공부하세요'),
(9, 'SPADE', 10, '오늘은 무얼 해도 공부가 잘되는 날입니다!'),
(10, 'SPADE', 11, '오늘은 무얼 해도 공부가 잘되는 날입니다!'),
(11, 'SPADE', 12, '오늘은 무얼 해도 공부가 잘되는 날입니다!'),
(12, 'SPADE', 13, '오늘은 무얼 해도 공부가 잘되는 날입니다!'),
(13, 'SPADE', 1, '최고의 학업운이 따르는 날! 밤샘 공부 고우!'),
(14, 'CLOVER', 2, '지금 바로 병원으로 진단 받으러 가보세요.'),
(15, 'CLOVER', 3, '오늘은 집에서 쉬시길 바랍니다'),
(16, 'CLOVER', 4, '오늘은 집에서 쉬시길 바랍니다'),
(17, 'CLOVER', 5, '오늘은 건강 관리에 신경을 써야 합니다.'),
(18, 'CLOVER', 6, '오늘은 건강 관리에 신경을 써야 합니다.'),
(19, 'CLOVER', 7, '평소 컨디션을 가지고 계시네요.'),
(20, 'CLOVER', 8, '평소 컨디션을 가지고 계시네요'),
(21, 'CLOVER', 9, '평소 컨디션을 가지고 계시네요'),
(22, 'CLOVER', 10, '오늘은 몸 걱정 마시고 계획하신 일 진행하세요!'),
(23, 'CLOVER', 11, '오늘은 몸 걱정 마시고 계획하신 일 진행하세요!'),
(24, 'CLOVER', 12, '오늘은 몸 걱정 마시고 계획하신 일 진행하세요!'),
(25, 'CLOVER', 13, '오늘은 몸 걱정 마시고 계획하신 일 진행하세요!'),
(26, 'CLOVER', 1, '오늘은 모든지 할 수 있는 컨디션을 가지고 계시네요!'),
(27, 'HEART', 2, '어디 나가시지 마시고 집에서 짜장면 드시는거 추천드립니다.'),
(28, 'HEART', 3, '고백을 생각하고 계셨다면 오늘은 참아주세요.'),
(29, 'HEART', 4, '고백을 생각하고 계셨다면 오늘은 참아주세요.'),
(30, 'HEART', 5, '고백을 생각하고 계셨다면 오늘은 참아주세요.'),
(31, 'HEART', 6, '고백을 생각하고 계셨다면 오늘은 참아주세요.'),
(32, 'HEART', 7, '좋아하는 상대에게 평소 하던대로 스몰토크를 해보세요.'),
(33, 'HEART', 8, '좋아하는 상대에게 평소 하던대로 스몰토크를 해보세요.'),
(34, 'HEART', 9, '좋아하는 상대에게 평소 하던대로 스몰토크를 해보세요.'),
(35, 'HEART', 10, '오늘은 좋아하시는 상대분과 같이 근사한 저녁 드셔보시는거 어떠세요?'),
(36, 'HEART', 11, '오늘은 좋아하시는 상대분과 같이 근사한 저녁 드셔보시는거 어떠세요?'),
(37, 'HEART', 12, '오늘은 좋아하시는 상대분과 같이 근사한 저녁 드셔보시는거 어떠세요?'),
(38, 'HEART', 13, '오늘은 좋아하시는 상대분과 같이 근사한 저녁 드셔보시는거 어떠세요?'),
(39, 'HEART', 1, '오늘은 집에 갈 생각하지마세요.'),
(40, 'DIAMOND', 2, '오늘은 집에 지갑을 두고 나오세요.'),
(41, 'DIAMOND', 3, '투자를 생각하신다면 오늘은 참아주세요.'),
(42, 'DIAMOND', 4, '투자를 생각하신다면 오늘은 참아주세요.'),
(43, 'DIAMOND', 5, '투자를 생각하신다면 오늘은 참아주세요.'),
(44, 'DIAMOND', 6, '투자를 생각하신다면 오늘은 참아주세요.'),
(45, 'DIAMOND', 7, '지금은 저축을 해야할 때!'),
(46, 'DIAMOND', 8, '지금은 저축을 해야할 때!'),
(47, 'DIAMOND', 9, '지금은 저축을 해야할 때!'),
(48, 'DIAMOND', 10, '오늘은 숨만 쉬어도 돈이 굴러들어올 겁니다.'),
(49, 'DIAMOND', 11, '오늘은 숨만 쉬어도 돈이 굴러들어올 겁니다.'),
(50, 'DIAMOND', 12, '오늘은 숨만 쉬어도 돈이 굴러들어올 겁니다.'),
(51, 'DIAMOND', 13, '오늘은 숨만 쉬어도 돈이 굴러들어올 겁니다.'),
(52, 'DIAMOND', 1, '당장 로또 사러 가세요!');

INSERT INTO balanceq (`index`, question_number, answer_left, score_s, score_c, score_h, score_d, problem, answer) values
(1, 1, TRUE, 1, -1, -1, 1, '지금 당신 뒤를 쫓아오는 것은?', '다리 없고 입에 피 흘리는 귀신'),
(2, 1, FALSE, -1, 1, 1, -1, '지금 당신 뒤를 쫓아오는 것은?', '한 달간 굶주린 호랑이'),
(3, 2, TRUE, 1, -1, -1, 0, '감기몸살로 하루종일 침대에 누워있던 당신 형, 오빠가 배고프다고 라면 끓여달라고 한다면?', '둘 다 굶고 안먹는다'),
(4, 2, FALSE, -1, 1, 1, 0, '감기몸살로 하루종일 침대에 누워있던 당신 형, 오빠가 배고프다고 라면 끓여달라고 한다면?', '아프지만, 착한 내가 챙겨주고 설거지까지 한다.'),
(5, 3, TRUE, -1, 1, 1, -1, '둘 중 당신이 먹을 오늘의 저녁은?', '따뜻한 냉면'),
(6, 3, FALSE, 1, -1, -1, 1, '둘 중 당신이 먹을 오늘의 저녁은?', '미지근한 라면'),
(7, 4, TRUE, -1, -1, -1, 1, '둘 중 당신의 이상형은?', '얼굴에 여드름 잔뜩 난 차은우 / 카리나'),
(8, 4, FALSE, 1, 1, 1, -1, '둘 중 당신의 이상형은?', '백옥 같은 피부의 김제동 / 신봉선'),
(9, 5, TRUE, 1, 1, -1, 1, '둘 중 당신이 선호하는 상황은?', '평생 넷플릭스 무료 이용권'),
(10, 5, FALSE, -1, -1, 1, -1, '둘 중 당신이 선호하는 상황은?', '평생 CGV 매달 영화관람권 2매 무료'),
(11, 6, TRUE, -1, 1, 1, -1, '둘 중 당신의 자녀계획은?', '자식 10명'),
(12, 6, FALSE, 1, -1, -1, 1, '둘 중 당신의 자녀계획은?', '자식 0명'),
(13, 7, TRUE, 1, 1, 0, -1, '둘 중 당신의 이상형은?', '요리 잘하는 못 생긴 남자/여자'),
(14, 7, FALSE, -1, -1, 1, 1, '둘 중 당신의 이상형은?', '예쁘지만 요리 못하는 남자/여자'),
(15, 8, TRUE, 1, 1, -1, 1, '샌드위치를 먹다가 씹힌 것은?', '바퀴벌레'),
(16, 8, FALSE, -1, -1, 1, -1, '샌드위치를 먹다가 씹힌 것은?', '당신 손가락 (피 철철..)'),
(17, 9, TRUE, 1, -1, -1, 1, '둘 중 당신이 원하는 학교생활은?', '전교 1등이지만 왕따'),
(18, 9, FALSE, -1, 1, 1, -1, '둘 중 당신이 원하는 학교생활은?', '전교 꼴등이지만 탑 인싸'),
(19, 10, TRUE, -1, 0, 1, -1, '둘 중 당신의 소망은?', '2025년 애인 생기기'),
(20, 10, FALSE, 1, 0, -1, 1, '둘 중 당신의 소망은?', '2025년 취직하기');

INSERT INTO todayslunch VALUES
(1, 'SPADE', 'CLOVER', '소고기 숯불구이'),
(2, 'SPADE', 'HEART', '짜장면'),
(3, 'SPADE', 'DIAMOND', '김밥'),
(4, 'CLOVER', 'SPADE', '고등어조림'),
(5, 'CLOVER', 'HEART', '국밥'),
(6, 'CLOVER', 'DIAMOND', '컵라면'),
(7, 'HEART', 'SPADE', '육회비빔밥'),
(8, 'HEART', 'CLOVER', '사골곰탕'),
(9, 'HEART', 'DIAMOND', '떡볶이'),
(10, 'DIAMOND', 'SPADE', '오리구이'),
(11, 'DIAMOND', 'CLOVER', '한방삼계탕'),
(12, 'DIAMOND', 'HEART', '초밥');

commit;