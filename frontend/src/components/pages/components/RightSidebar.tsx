import React from 'react';
import { HotPost, Board } from '../../../types';
import './RightSidebar.scss';

interface RightSidebarProps {
  hotPosts: HotPost[];
  bestBoards: Board[];
}

const RightSidebar: React.FC<RightSidebarProps> = ({ hotPosts, bestBoards }) => {
  return (
    <div className="right-sidebar">
      <div className="sidebar-section">
        <h3 className="section-title">🔥 인기 게시글</h3>
        <div className="hot-posts-list">
          {hotPosts.length > 0 ? (
            hotPosts.map((post) => (
              <div key={post.id} className="hot-post-item">
                <div className="post-title">{post.title}</div>
                <div className="post-info">
                  <span className="author">{post.author}</span>
                  <div className="post-stats">
                    <span className="stat">👁 {post.viewCount}</span>
                    <span className="stat">💬 {post.commentCount}</span>
                    <span className="stat">❤️ {post.likeCount}</span>
                  </div>
                </div>
              </div>
            ))
          ) : (
            <div className="no-content">인기 게시글이 없습니다.</div>
          )}
        </div>
      </div>

      <div className="sidebar-section">
        <h3 className="section-title">📌 인기 게시판</h3>
        <div className="best-boards-list">
          {bestBoards.length > 0 ? (
            bestBoards.map((board) => (
              <div key={board.id} className="board-item">
                <div className="board-header">
                  {board.icon && <span className="board-icon">{board.icon}</span>}
                  <span className="board-name">{board.name}</span>
                </div>
                {board.description && (
                  <div className="board-description">{board.description}</div>
                )}
                <div className="board-stats">
                  게시글 {board.postCount}개
                </div>
              </div>
            ))
          ) : (
            <div className="no-content">인기 게시판이 없습니다.</div>
          )}
        </div>
      </div>
    </div>
  );
};

export default RightSidebar;
