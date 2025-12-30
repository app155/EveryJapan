import React, { useState } from 'react';
import './Header.scss';

const Header: React.FC = () => {
  const [searchQuery, setSearchQuery] = useState('');

  const handleSearch = (e: React.FormEvent) => {
    e.preventDefault();
    console.log('검색:', searchQuery);
    // TODO: 검색 기능 구현
  };

  return (
    <header className="main-header">
      <div className="header-container">
        <div className="logo-section">
          <div className="logo-image">
            {/* TODO: 로고 이미지 추가 */}
            <span className="logo-text">ポリ</span>
          </div>
        </div>

        <div className="title-section">
          <h1 className="site-title">GLOBALIN</h1>
          <p className="site-subtitle">일본 유학생 커뮤니티</p>
        </div>

        <div className="search-section">
          <form onSubmit={handleSearch} className="search-form">
            <input
              type="text"
              placeholder="소 게시물 검색..."
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
              className="search-input"
            />
            <button type="submit" className="search-button">
              🔍
            </button>
          </form>
        </div>
      </div>
    </header>
  );
};

export default Header;
