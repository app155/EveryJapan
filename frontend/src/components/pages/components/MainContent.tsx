import React from 'react';
import { Post } from '../../../types';
import './MainContent.scss';

interface MainContentProps {
  humanitiesPosts: Post[];
  freePosts: Post[];
}

const MainContent: React.FC<MainContentProps> = ({ humanitiesPosts, freePosts }) => {
  const renderPostList = (posts: Post[], title: string) => (
    <div className="post-section">
      <h2 className="section-title">{title}</h2>
      <div className="post-list">
        {posts.length > 0 ? (
          posts.map((post) => (
            <div key={post.id} className="post-item">
              <div className="post-header">
                <h3 className="post-title">{post.title}</h3>
                <span className="post-author">{post.author}</span>
              </div>
              <p className="post-preview">
                {post.content.substring(0, 100)}
                {post.content.length > 100 ? '...' : ''}
              </p>
              <div className="post-meta">
                <span className="meta-item">
                  조회 {post.viewCount}
                </span>
                <span className="meta-item">
                  댓글 {post.commentCount}
                </span>
                <span className="meta-item">
                  좋아요 {post.likeCount}
                </span>
                <span className="meta-item post-date">
                  {new Date(post.createdAt).toLocaleDateString('ko-KR')}
                </span>
              </div>
            </div>
          ))
        ) : (
          <div className="no-posts">게시글이 없습니다.</div>
        )}
      </div>
    </div>
  );

  return (
    <div className="main-content">
      {renderPostList(humanitiesPosts, '인문학 게시판')}
      {renderPostList(freePosts, '자유 게시판')}
    </div>
  );
};

export default MainContent;
