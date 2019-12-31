# NHN-basecamp-pretest

## Board(게시판) 만들기 <br> 조은지 

### Page Description

#### 'board' 
*게시글 리스트를 확인할 수 있는 페이지.* <br>
게시글 작성 시 자동으로 부여되는 id와 글 제목, 글쓴이 닉네임, 글 작성시각, 수정시각을 확인할 수 있다. <br>
게시글 제목을 클릭하면 해당 게시글을 읽을 수 있는 'read'페이지로 연결 된다. <br>
하단 'write'버튼 누를 시에 게시글을 작성할 수 있는 'write'페이지로 연결 된다. <br>

#### 'read' 
*게시글 세부내용을 확인할 수 있는 페이지.* <br>
게시글 제목과 작성자 닉네임, 이메일, 본문 내용을 확인할 수 있다. <br>
하단에 '수정' 버튼을 누를 시에 비밀번호를 입력 후 게시글을 수정 혹은 삭제할 수 있는 페이지로 연결된다. <br>
하단에 '목록' 버튼을 누를 시에는 기존 'board'페이지로 돌아간다. <br>

#### 'write' 
*게시글을 작성할 수 있는 페이지.* <br>
제목, 닉네임, 이메일, 비밀번호, 본문을 입력할 수 있다. <br>
글 작성 시에 자동으로 시각이 저장되며, 본문을 제외한 값들은 빈 칸으로 채울 수 없다. <br>
이메일은 프론트에서 **html type**을 통해 검사되며, 서버에서는 **정규식을 통해 유효성 검사**를 실시한다. <br>

#### 'update'
*게시글을 수정 혹은 삭제할 수 있는 페이지.* <br>
게시글 작성 시에 작성한 모든 정보를 수정하거나, 게시글을 삭제할 수 있다. <br>
update 페이지로 넘어가기 전에 **비밀번호 입력 필터**를 거쳐야 한다. <br>
입력된 비밀번호는 세션으로 임시로 관리되며 수정 후 목록으로 돌아가거나 수정 취소를 누를 경우 세션은 초기화된다. <br>
글 수정 등록 시 수정 시각 또한 자동으로 저장된다. <br>

#### 'password'
*update 페이지로 넘어가기 전 비밀번호 확인 페이지.* <br>
update 페이지로 넘어가기 전에 비밀번호를 입력 받는다. <br>
**filter로 구현**되어 있기 때문에 버튼이 아닌 url로 update 페이지에 접근할 경우에도 거쳐가도록 되어있다. <br>

### DTO(Data Transfer Object)(=VO) Description

#### Writing
Variables : id, title, name, email, password, content, write_date, mod_date <br>
변수들 및 해당 변수들의 get, set method로 구현되어 있다. <br>
!https://github.com/96ycho/NHN-basecamp-pretest/blob/master/img/WritingVo.png

### DAO(Data Access Object) Description 

#### MySQL Database
!https://github.com/96ycho/NHN-basecamp-pretest/blob/master/img/[mysql]desc_board.png

#### WritingDao
데이터베이스 접속을 위한 Object <br>
getBoard : 게시글 리스트를 불러오는 method. <br>
insert : 데이터 추가를 위한 method. <br>
delete : 데이터 삭제를 위한 method. <br>
update : 데이터 수정을 위한 method. <br>
getWriting : 특정 id의 게시글을 불러오는 method. <br>
getPassword : 특정 id의 게시글의 비밀번호를 불러오는 method. <br>

### 전체 구조
!https://github.com/96ycho/NHN-basecamp-pretest/blob/master/img/pretest.png
