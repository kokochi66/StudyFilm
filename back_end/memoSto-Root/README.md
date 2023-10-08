# MemorialStorage 프로젝트 중앙 서버

MemorialStorage 프로젝트의 중앙 데이터를 보관하는 Restful API 서버입니다.
해당 프로젝트의 모든 기초 데이터들이 보관되며, 다른 서버들에서는 이 중앙 서버에서 사용자 및 컨텐츠 데이터를 가져와서 활용합니다.
저장시에도 실 파일은 이 중앙 서버에 직접 저장됩니다.


## 중앙 서버를 별도로 두는 장점

로컬 파일을 위주로 사용하기 때문에, 프로젝트의 다양하게 사용되는 컨텐츠 파일들이나 사용자 데이터가 뿔뿔히 흩어져있으면, 관리에 어렵기 때문에 중앙 서버를 별도로 두어서 저장하여, 해당 중앙 서버의 데이터만 보관하면 다른 프로젝트들은 크게 백업이 필요없는 구조로 구성할 수 있습니다.


## 프로젝트 진행

- [2022/08 프로젝트 진행](./prj/202208.md)
- [2022/09 프로젝트 진행](./prj/202209.md)
